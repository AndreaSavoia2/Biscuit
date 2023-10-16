import React, { useState } from 'react';
import './Login.css';
import { Link } from 'react-router-dom';

function Login() {

    const initialValues = {
        email: '',
        password: ''
    };

    const [userValues, setUserValues] = useState(initialValues);
    const [user, setUser] = useState('');

    const valueHandler = (event) => {
        const { name, value } = event.target;
        setUserValues(prevValues => ({
            ...prevValues,
            [name]: value
        }))
    }


    const eventLogin = (event) => {
        event.preventDefault();
        fetch("http://localhost:9000/api/utenti")
    .then((response) => response.json())
    .then((data) => {
        setUser([data.initialValues]);
        console.log(data);
    })
    }

  return (
    <div className='login template d-flex justify-content-center align-items-center vh-100 bg-primary'>
        <div className='form_container border p-5 rounded bg-white'>
        <form>
            <h3>Sign in</h3>
            <div className='mb-2'>
                <label htmlFor='email'>Email</label>
                <input type='email' name='email' placeholder='Enter Email' className='form-control' onChange={valueHandler} value={userValues.email}></input>
            </div>
            <div className='mb-2'>
                <label htmlFor='password'>Password</label>
                <input type='password' name='password' placeholder='Enter Password' className='form-control' onChange={valueHandler} value={userValues.password}></input>
            </div>
            <div className='mb-2'>
                <input type='checkbox' className='custom-control custom-checkbox' id='check'></input>
                <label htmlFor='check' className='custom-input-label ms-2'>Remember me</label>
            </div>
            <div className='d-grid'>
                <button className='btn btn-primary' onClick={eventLogin}>Sign in</button>
            </div>
            <p className='text-end mt-2'>
                Forgot <a href=''>Password?</a><Link to='/signup' className='ms-2'>Sign up</Link>
            </p>
        </form>
        </div>
    </div>
  )
}

export default Login;