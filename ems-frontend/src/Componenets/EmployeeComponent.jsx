import React, {useState} from 'react';
import {CreateEmolyee} from "../service/EmployeeService.jsx";
import {useNavigate} from "react-router-dom";

const EmployeeComponent = () => {

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');

    // const  handleFirstName = (e) => setFirstName(e.target.value);

    // const handleLastName = (e) => setLastName(e.target.value);

    // const handleEmail = (e) => setEmail(e.target.value);

    const navigator = useNavigate();

    const [error, setError] = useState({
        firstName:'',
        lastName:'',
        email:''
    })

    function saveEmployee(e){
        e.preventDefault();

        if (validForm()) {
            const employee = {firstName, lastName, email};
            console.log(employee)

            CreateEmolyee(employee).then((response) => {
                console.log(response.data);
                navigator('/');
            })
        }
    }
    
    function validForm() {
        let valid = true;
        const errorsCoppy = {...error}

        if (firstName.trim()) {
            errorsCoppy.firstName = '';
        } else {
            errorsCoppy.firstName = 'First Name is required';
            valid = false;
        }

        if (lastName.trim()) {
            errorsCoppy.lastName = '';
        } else {
            errorsCoppy.lastName = 'Last Name is required';
            valid = false;
        }

        if (email.trim()) {
            errorsCoppy.email = '';
        } else {
            errorsCoppy.email = 'Email is required';
            valid = false;
        }

        setError(errorsCoppy);
        return valid;
    }

    return (
        <div>
            <form action="">
                <div>
                    <label htmlFor=""> first name :</label>
                    <input
                        type="text"
                        name='firstname'
                        value={firstName}
                        onChange={(e) => setFirstName(e.target.value)}
                    />
                    {error.firstName && <div style={{color:"red"}}> {error.firstName} </div>}
                </div>
                <div>
                    <label htmlFor=""> Last name :</label>
                    <input
                        type="text"
                        name='lastname'
                        value={lastName}
                        onChange={(e) => setLastName(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor=""> Email :</label>
                    <input
                        type="text"
                        name='email'
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                </div>
                <button onClick={saveEmployee}>Save</button>
            </form>
        </div>
    );
};

export default EmployeeComponent;