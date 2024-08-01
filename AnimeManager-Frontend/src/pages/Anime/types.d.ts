type searchAnimeApiResp = {
    code: number
    message: string
    data: searchAnimeData[]
}

type searchAnimeData = {
    id: string
    name: string
    chineseName: string
    cover: string
    summary: string
}

type dailyAnimeApiResp = {
    code: number
    message: string
    data: dailyAnimeData[]
}

type dailyAnimeData = {
    id: string
    name: string
    chineseName: string
    cover: string
    summary: string
}

export type { searchAnimeApiResp, searchAnimeData, dailyAnimeApiResp, dailyAnimeData };