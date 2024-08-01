import React from 'react'
import ReactDOM from 'react-dom/client'
import { RouterProvider } from 'react-router-dom';
import { NextUIProvider } from '@nextui-org/react'
import router from "./routes";
import './index.css'

ReactDOM.createRoot(document.getElementById('root')!).render(
    <React.StrictMode>
        <NextUIProvider>
            <main className="dark text-foreground bg-background bg-opacity-0">
                <RouterProvider router={router}/>
            </main>
        </NextUIProvider>
    </React.StrictMode>
    ,
)
