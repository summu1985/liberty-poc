import axios from 'axios';

const Employees_Rest_Api_Url='http://localhost:8080/api/employees';

class EmployeeSevice {

    getEmployees(){

        return axios.get(Employees_Rest_Api_Url);
    }
}

export default new EmployeeSevice()