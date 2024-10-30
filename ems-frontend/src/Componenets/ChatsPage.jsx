// import { PrettyChatWindow } from "react-chat-engine-pretty";
//
// const ChatsPage = (props) => {
//     return (
//         <div style={{ height: "100vh", width: "100vw" }}>
//             <PrettyChatWindow
//                 projectId="d70927aa-b38e-4916-9227-eb481e420eb6"
//                 username={props.user.username} // adam
//                 secret={props.user.secret} // pass1234
//                 style={{ height: "100%" }}
//             />
//         </div>
//     );
// };
//
// export default ChatsPage;

import React, { useState } from 'react';
import { PrettyChatWindow } from "react-chat-engine-pretty";

const ChatsPage = (props) => {
    const [username, setUsername] = useState(props.user.username); // Initial username value
    const [secret, setSecret] = useState(props.user.secret); // Initial secret value

    // Function to handle username change
    const handleUsernameChange = (newUsername) => {
        setUsername(newUsername);
    };

    // Function to handle secret change
    const handleSecretChange = (newSecret) => {
        setSecret(newSecret);
    };

    return (
        <div style={{ height: "100vh", width: "100vw" }}>
            <PrettyChatWindow
                projectId="d70927aa-b38e-4916-9227-eb481e420eb6"
                username={username}
                secret={secret}
                style={{ height: "100%" }}
            />
        </div>
    );
};

export default ChatsPage;
