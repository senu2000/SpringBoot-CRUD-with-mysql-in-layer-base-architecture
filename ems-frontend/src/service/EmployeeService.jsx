import axios from "axios";

const REST_API_BASE_USRL = "http://localhost:8080/api/employees";

export const ListEmployees = () => axios.get(REST_API_BASE_USRL);

export const CreateEmolyee = (employee) => axios.post(REST_API_BASE_USRL, employee);
