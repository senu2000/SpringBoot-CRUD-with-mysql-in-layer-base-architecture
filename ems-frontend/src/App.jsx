import './App.css'
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./Pages/Home.jsx";
import PaintItems from "./Pages/PaintItems.jsx";
import SearchResults from "./Pages/SearchResults.jsx";
import AllProjects from "./Pages/AllProjects.jsx";
import EmployeeComponent from "./Componenets/EmployeeComponent.jsx";

function App() {

  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route index element={<Home/>}/>
            <Route path="/home" element={<Home/>}/>
            <Route path="/paintItems" element={<PaintItems/>}/>
            <Route path="/searchResult" element={<SearchResults/>}/>
            <Route path="/allProjects" element={<AllProjects/>}/>
          <Route path="/add-employee" element={<EmployeeComponent/>}/>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
