import { createBrowserRouter } from "react-router-dom";
import Anime from "../pages/Anime/Anime.tsx";
import App from "../App.tsx";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App />,
        children: [
            {
                path: "anime",
                element: <Anime />
            }
        ]
    }
]);

export default router