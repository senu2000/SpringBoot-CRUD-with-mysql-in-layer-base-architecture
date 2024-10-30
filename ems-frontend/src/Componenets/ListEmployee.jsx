import React, {useEffect, useState} from 'react';
import {ListEmployees} from "../service/EmployeeService.jsx";
import {useNavigate} from "react-router-dom";

const ListEmployee = () => {

    const [employees, setEmployees] = useState([]);
    const navigator = useNavigate();

    useEffect(() => {
        ListEmployees().then((response) => {
            setEmployees(response.data);
        }).catch(error => {
            console.error(error);
        })
    }, []);

    function addNewEmployee(){
        navigator('/add-employee')
    }

    return (
        <div>
            <h2>All Employees</h2>
            <button onClick={addNewEmployee}>Add Employee</button>
            <table>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>
                </thead>
                <tbody>
                {employees.map(employee =>
                    <tr key={employee.id}>
                        <td>{employee.id}</td>
                        <td>{employee.firstName}</td>
                        <td>{employee.lastName}</td>
                        <td>{employee.email}</td>
                    </tr>
                )}
                </tbody>
            </table>
        </div>
    );
};

export default ListEmployee;