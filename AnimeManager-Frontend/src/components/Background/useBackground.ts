import { useEffect, useState } from "react";
import type { UseBackgroundProps } from "./types";

function useBackground({images, interval}: UseBackgroundProps) {
    const [currentImage, setCurrentImage] = useState(0);
    const [previousImage, setPreviousImage] = useState(interval);

    useEffect(() => {
        const intervalId = setInterval(() => {
            // 设置上一个图片为当前图片
            setPreviousImage(currentImage);
            // 设置当前图片为下一个图片
            setCurrentImage((currentImage + 1) % images.length);
        }, interval);

        return () => clearInterval(intervalId);
    }, [currentImage, images.length, interval]);

    return {currentImage, previousImage};
}

export default useBackground;