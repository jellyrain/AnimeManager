import { Button, Card, CardFooter, Image } from "@nextui-org/react";
import useAnime from "./useAnime.ts";

function Anime() {
    const {anime} = useAnime()

    return <div className="max-w-screen h-full grid grid-cols-6 gap-7">
        {anime && anime.map((anime) => <Card key={anime.id} isFooterBlurred className="w-80 h-[430px] col-span-1">
            <Image
                removeWrapper
                alt="Relaxing app background"
                className="z-0 w-full h-full object-cover"
                src={anime.cover}
            />
            <CardFooter
                className="absolute bg-black/40 bottom-0 z-10 border-t-1 border-default-600 dark:border-default-100">
                <div className="flex flex-grow gap-2 items-center">
                    <div className="flex flex-col">
                        <p className="text-2xl text-white/90">{anime.chineseName}</p>
                        <p className="text-tiny text-white/90 ">{anime.name}</p>
                    </div>
                </div>
                <Button radius="full" size="sm">查看详情</Button>
            </CardFooter>
        </Card>)}
    </div>
}

export default Anime;