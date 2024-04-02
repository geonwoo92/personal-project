import { ReactNode } from "react"

export interface IArticle{
    id: number,
    title: string,
    content: string,
    registerDate: string,
    writer: ReactNode,
    array: []

}