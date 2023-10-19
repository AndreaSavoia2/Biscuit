import React, { useState } from 'react';
import { Link } from 'react-router-dom';

const Signup = () => {
    const initialValues = {
        username: '',
        email: '',
        password: '',
    }

    const [userData, setUserData] = useState(initialValues);

    const valueHandler = (event) => {
        const { name, value } = event.target;
        setUserData((prevValues) => ({
            ...prevValues,
            [name]: value
        }));
      };

    const eventSignup = () => {
        fetch("http://localhost:9000/api/utenti", {
            method: 'POST',
            headers: { "content-type": "application/json", },
            body: JSON.stringify(userData)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Errore nella richiesta');
            }
            return response.json();
        })
        .then(data => {
            setUserData([data]);
            sessionStorage.setItem("loggedInUser", JSON.stringify(userData));
            window.location.href = '/user';
            console.log(data);
        })
        .catch(error => {
            console.error('Si è verificato un errore:', error);
        });
    }

  return (
    <div className='signup template d-flex justify-content-center align-items-center vh-100 bg-primary'>
        <div className='form_container border p-5 rounded bg-white'>
        <form>
            <h3>Sign Up</h3>
            <div className='mb-2'>
                <label htmlFor='fname'>Username</label>
                <input type='text' name='username' value={userData.username} placeholder='Enter Username' className='form-control' onChange={valueHandler}></input>
            </div>
            <div className='mb-2'>
                <label htmlFor='email'>Email</label>
                <input type='email' name='email' value={userData.email} placeholder='Enter Email' className='form-control' onChange={valueHandler}></input>
            </div>
            <div className='mb-2'>
                <label htmlFor='password'>Password</label>
                <input type='password' name='password' value={userData.password} placeholder='Enter Password' className='form-control' onChange={valueHandler}></input>
            </div>
            <div className='d-grid'>
                <button className='btn btn-primary mt-2' onClick={eventSignup}>Sign Up</button>
            </div>
            <p className='text-end mt-2'>
                Already Registered: <Link to='/' className='ms-2'>Sign in</Link>
            </p>
        </form>
        </div>
    </div>
  )
}

export default Signup;