import { searchAnimeApiResp, dailyAnimeApiResp } from "../pages/Anime/types";

async function searchAnime(keyword: string): Promise<searchAnimeApiResp> {
    const response = await fetch(`http://127.0.0.1:8080/bangumi/search?keyword=${keyword}`);
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }
    const data = await response.json();
    return data as searchAnimeApiResp;
}

async function dailyAnime(keyword: string): Promise<dailyAnimeApiResp> {
    const response = await fetch(`http://127.0.0.1:8080/bangumi/daily?weekday=${keyword}`);
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }
    const data = await response.json();
    return data as dailyAnimeApiResp;
}


export { searchAnime, dailyAnime };