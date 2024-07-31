import React from 'react'
import ReactDOM from 'react-dom/client'
import { BrowserRouter } from 'react-router-dom';
import { NextUIProvider } from '@nextui-org/react'
import App from './App.tsx'
import './index.css'

ReactDOM.createRoot(document.getElementById('root')!).render(
    <React.StrictMode>
        <NextUIProvider>
            <BrowserRouter>
                <main className="dark text-foreground bg-background bg-opacity-0">
                    <App/>
                </main>
            </BrowserRouter>
        </NextUIProvider>
    </React.StrictMode>
    ,
)
