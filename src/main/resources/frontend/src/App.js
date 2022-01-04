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
        <div className="w-100 h-100">
            <h1 className="h1 text-center p-3">Dodaj swoją pracę</h1>
            <div className="bg-primary bg-gradient">
                <FormMain/>

            </div>
            <div className="bg-success bg-gradient p-3">
                <Table/>
            </div>
        </div>
    );
}

export default App;
