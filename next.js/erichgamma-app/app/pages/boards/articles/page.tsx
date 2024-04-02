'use client'

import { useState, useEffect } from "react"
import { useSelector, useDispatch } from 'react-redux'
import { NextPage } from "next";
import { fetchAllArticles } from "@/redux/features/articles/article.service";
import { getAllArticles } from "@/redux/features/articles/article.slice";
import { DataGrid } from "@mui/x-data-grid";
import Columns from "@/app/component/articles/columns";
import { Box } from "@mui/material";
// import React from "react";
interface IArticle {
  id: number,
  title: string,
  content: string,
  writer: string,
  registerDate: string
}


const ArticlesPage: NextPage = ({data}:any) => {
  const dispatch = useDispatch()

  const allArticles: [] = useSelector(getAllArticles)

  if (allArticles !== undefined) {
      console.log('allArticles is not undefined')

      console.log('length is ' + allArticles.length)
      for (let i = 0; i < allArticles.length; i++) {
          console.log(JSON.stringify(allArticles[i]))
      }
  } else {
      console.log('allArticles is undefined')
  }

  useEffect(() => {
      dispatch(fetchAllArticles(1))
  }, [])

  return (<>
      <h2>개인페이지 Article</h2>
      <Box sx={{ height: 400, width: '100%' }}>
      <DataGrid
        rows={data}
        columns={Columns()}
        initialState={{
          pagination: {
            paginationModel: {
              pageSize: 5,
            },
          },
        }}
        pageSizeOptions={[5]}
        checkboxSelection
        disableRowSelectionOnClick
      />
    </Box>
  </>)
}

export default ArticlesPage