import './App.css'
import Background from "./components/Background/Background.tsx";
import Nav from "./components/Nav/Nav.tsx";

function App() {
    const images = ['1.png', '2.png', '3.png', '4.png', '5.png', '6.png', '7.png']

    return (
        <>
            <Background images={images}/>
            <Nav/>
        </>
    )
}

export default App
