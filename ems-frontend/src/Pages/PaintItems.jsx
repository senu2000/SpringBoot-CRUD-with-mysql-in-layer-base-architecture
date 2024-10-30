import React, {useState} from 'react';
import ChatsPage from "../Componenets/ChatsPage.jsx";
import AuthPage from "../Componenets/AuthPage.jsx";

function PaintItems(props) {
    const [user, setUser] = useState();

    if (!user) {
        return <AuthPage onAuth={(user) => setUser(user)} />;
    } else {
        return <ChatsPage user={user} />;
    }
}
export default PaintItems;