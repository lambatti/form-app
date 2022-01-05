import React, {useEffect, useState} from "react";
import axios from "axios";


const Table = () => {

    const [data, setData] = useState([{
        title: "Nowy",
        affiliation: 'SGGW',
        authors: [{firstName: "Adam", lastName: "Tomaszewski", email: "email@wp.pl"}, {
            firstName: "Kamil",
            lastName: "Najlepszy",
            email: "siemka@wp.pl"
        }],
        reviewers: [{firstName: "Adam", lastName: "Tomaszewski", email: "email@wp.pl"}, {
            firstName: "Adam",
            lastName: "Tomaszewski",
            email: "email@wp.pl"
        }]
    }]);

    useEffect(() => {
        axios.get('/api/article').then(resp => setData(resp.data))
    }, [])


    return (
        <>
            <h3>Tabela artykułów</h3>
            <table className="table table-bordered">
                <thead className="table-info">
                <tr>
                    <th>Tytuł</th>
                    <th>Afiliacja</th>
                    <th>Autorzy</th>
                    <th>Kontakt</th>
                    <th>Recenzenci</th>
                </tr>
                </thead>
                <tbody className="table-dark">
                {data.map((v) => <tr>
                    <td>{v.title}</td>
                    <td>{v.affiliation}</td>
                    <td>
                        <ul>{v.authors.map(x => <li>{`${x.firstName} ${x.lastName}`}</li>)}</ul>
                    </td>
                    <td>
                        <ul>{v.authors.map(x => <li>{x.email}</li>)}</ul>
                    </td>
                    <td><ul>{v.reviewers.map(x => <li>{`${x.firstName} ${x.lastName}`}</li>)}</ul></td>
                </tr>)}

                </tbody>
            </table>
        </>
    )
}

export default Table;