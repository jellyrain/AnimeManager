import './App.css'
import Background from "./components/Background/Background.tsx";
import Nav from "./components/Nav/Nav.tsx";
import { Outlet } from "react-router-dom";

function App() {
    const images = ['1.png', '2.png', '3.png', '4.png', '5.png', '6.png', '7.png']

    return (
        <>
            <Background images={images}/>
            <div className="w-screen h-screen flex flex-col">
                <Nav/>
                <div className="bg-background bg-opacity-75 flex-grow overflow-hidden overflow-y-scroll p-8">
                    <Outlet/>
                </div>
                <div className="w-screen h-10 bg-background bg-opacity-75"></div>
            </div>
        </>
    )
}

export default App
