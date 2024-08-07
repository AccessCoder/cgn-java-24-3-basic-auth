import './App.css'
import {Route, Routes} from "react-router-dom";
import LoginPage from "./LoginPage.tsx";
import {useEffect, useState} from "react";
import HelloPage from "./HelloPage.tsx";
import ProtectedRoute from "./ProtectedRoute.tsx";
import axios from "axios";
import RegisterPage from "./RegisterPage.tsx";

function App() {

    const [user, setUser] = useState<string>("anonymousUser")

    useEffect(() => {
        axios.get("/api/user")
            .then((r) => setUser(r.data))
    }, [])

    function logout(){
        axios.get("/api/user/logout")
            .then(() => setUser("anonymousUser"))
    }

    return (
        <>
            <button onClick={logout}>Logout</button>
            <Routes>
                <Route element={<RegisterPage/>} path={"/"}/>
                <Route element={<LoginPage setUser={setUser}/>} path={"/login"}/>
                <Route element={<ProtectedRoute user={user}/>}>
                    <Route element={<HelloPage/>} path={"/hello"}/>
                </Route>
            </Routes>
        </>
    )
}

export default App
