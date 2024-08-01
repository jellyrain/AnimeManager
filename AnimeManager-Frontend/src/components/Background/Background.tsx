import styles from './Background.module.css'
import useBackground from "./useBackground.ts";
import type { BackgroundProps } from "./types";


function Background({images}: BackgroundProps) {
    const {currentImage, previousImage} = useBackground({images, interval: 10000});

    return <div className={styles.carousel}>
        {images && images.map((image, index) => (
            <div
                key={index}
                className={`${styles['carousel-image']} ${index === currentImage ? styles.active : ''} ${index === previousImage ? styles.previous : ''}`}
                style={{backgroundImage: `url(${image})`}}
            />
        ))}
    </div>
}

export default Background;