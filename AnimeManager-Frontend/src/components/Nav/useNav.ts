import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";

function useNav() {
    const location = useLocation();
    const [activeItem, setActiveItem] = useState(location.pathname);

    useEffect(() => {
        setActiveItem(location.pathname);
    }, [location.pathname]);

    return {activeItem};
}

export default useNav;