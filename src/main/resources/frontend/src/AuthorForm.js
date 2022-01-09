import React from "react";


const AuthorForm = ({firstName, lastName, email, onChanged}) => (
    <>
            <h3 className="text-center p-3 display-6">Dodaj autora artykułu</h3>
    <form className="col-14">
        <label className="form-label text-secondary">Imię</label>
        <input className="form-control" value={firstName} name={"firstName"} onChange={(e) => onChanged(e.target.value)}/>
        <label className="form-label text-secondary">Nazwisko</label>
        <input className="form-control" value={lastName} name={"lastName"} onChange={(e) => onChanged(firstName, e.target.value, null)}/>
        <label className="form-label text-secondary">Email</label>
        <input className="form-control" value={email} name={"email"} onChange={(e) => onChanged(firstName, lastName, e.target.value)}/>
    </form>

    </>
);


export default AuthorForm;