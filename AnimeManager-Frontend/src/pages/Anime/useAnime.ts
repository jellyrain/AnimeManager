import { useEffect, useState } from "react";
import { dailyAnimeData } from "./types";
import { dailyAnime } from "../../api/bangumiApi.ts";

function useAnime() {
    const [anime, setAnime] = useState<dailyAnimeData[]>([]);

    useEffect(() => {
        async function fetchData() {
            const anime = await dailyAnime("5");
            setAnime(anime.data);
        }

        fetchData().then(r => r);
    }, []);

    return {anime};
}

export default useAnime