import './App.css';
import {useEffect} from "react";
import axios from "axios";
import FormMain from "./FormMain";
import Table from "./Table";

const App = () => {

    useEffect(() => {
        axios.get('/api/test').then(resp => console.log(resp))
    })


    return (
        <div className="">
            <h1 className="text-center p-3 display-6">Dodaj swoją pracę</h1>
            <div className="">
                <FormMain/>
            </div>
            <div className="p-3">
                <Table/>
            </div>
        </div>
    );
}

export default App;
