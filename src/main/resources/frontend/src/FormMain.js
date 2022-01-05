import React, {useState} from "react";
import AuthorForm from "./AuthorForm";
import axios from "axios";


const FormMain = () => {

    const [title, setTitle] = useState('');
    const [affiliation, setAffiliation] = useState('');
    const [content, setContent] = useState('');

    const [errmsg ,setErrmsg] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log({title, affiliation, content, authors})
        axios.post('/api/article', {
            title,
            affiliation,
            content,
            authors
        }).catch(() => setErrmsg(`Nie można wykonać dodania do bazy danych`));
    }

    const [authors, setAuthors] = useState([{firstName: '', lastName: '', email: ''}])

    return (
        <>
            <h2 className="text-danger">{errmsg !== '' ? errmsg : null}</h2>
            <form className="col-6 m-3" onSubmit={handleSubmit}>
                <label className="form-label">Tytuł</label>
                <input className="form-control" name={"title"} value={title}
                       onChange={(e) => setTitle(e.target.value)}/>
                <label className="form-label">Afiliacja</label>
                <input className="form-control" name={affiliation} value={affiliation}
                       onChange={(e) => setAffiliation(e.target.value)}/>
                <label className="form-label">Artykuł</label>
                <textarea className="form-control" name={"content"} value={content}
                          onChange={(e) => setContent(e.target.value)}/>

                {authors.map((x, i) => (<AuthorForm onChanged={(firstName, lastName, email) => {
                    setAuthors([
                        ...authors.filter((x, n) => n < i),
                        {firstName: firstName, lastName: lastName, email: email},
                        ...authors.filter((x, n) => n > i)
                    ]);
                }} key={i} {...x} />))}
                <button className="btn bg-warning m-2" onClick={() => setAuthors([...authors, {email: '', firstName: '', lastName: ''}])}>+</button>
                <button className="btn btn-outline-warning text-warning float-end" type={"submit"}>Wyślij</button>
            </form>


        </>

    )
}


export default FormMain;


