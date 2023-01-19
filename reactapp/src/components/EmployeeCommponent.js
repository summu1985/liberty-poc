import React from "react";
import EmployeeService from "../services/EmployeeService";

class EmployeeComponent extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            employees:[]
        }
    }
    componentDidMount(){
        EmployeeService.getEmployees().then((Response)=>{
            this.setState({employees:Response.data})
        });
    }
    render(){
        return(
            <div>
                <h1 className="text-center">LIST OF EMPLOYEES</h1>
                <table className="table table-stripes"></table>
                <thead>
                    <tr>
                        <td> EMPLOYEE_ID</td>
                        <td> EMPLOYEE_NAME</td>
                        <td> EMPLOYEE_EMAIL</td>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.employees.map(
                            employee =>
                            <tr key = {employee.id}>
                                <td> {employee.id}</td>
                                <td> {employee.name}</td>
                                <td> {employee.email}</td>
                            </tr> 
                        )
                    }
                </tbody>
            </div>
        )
    }
}

export default EmployeeComponent