import { Navbar, NavbarBrand, NavbarContent, NavbarItem } from "@nextui-org/react";
import { NavLink } from 'react-router-dom';
import useNav from "./useNav.ts";

function Nav() {
    const {activeItem} = useNav();

    return <Navbar maxWidth="full">
        <NavbarBrand className="ml-10">
            <p className="font-bold text-inherit">AnimeManager</p>
        </NavbarBrand>
        <NavbarContent className="hidden sm:flex gap-10 mr-20" justify="center">
            <NavbarItem isActive={activeItem === "/"}>
                <NavLink className={({isActive}) => isActive ? "text-primary" : "text-foreground"} to="/">
                    首页
                </NavLink>
            </NavbarItem>
            <NavbarItem isActive={activeItem === "/anime"}>
                <NavLink className={({isActive}) => isActive ? "text-primary" : "text-foreground"} to="/anime">
                    番剧管理
                </NavLink>
            </NavbarItem>
            <NavbarItem isActive={activeItem === "/config"}>
                <NavLink className={({isActive}) => isActive ? "text-primary" : "text-foreground"} to="/config">
                    系统管理
                </NavLink>
            </NavbarItem>
            <NavbarItem isActive={activeItem === "/about"}>
                <NavLink className={({isActive}) => isActive ? "text-primary" : "text-foreground"} to="/about">
                    关于我们
                </NavLink>
            </NavbarItem>
        </NavbarContent>
    </Navbar>
}

export default Nav;