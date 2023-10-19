import React, { useState } from 'react';
import './Login.css';
import { Link } from 'react-router-dom';
import User from './User.js';


const Login = () => {
    const initialValues = {
      email: '',
      password: '',
      rememberMe: false
    };

    const [userValues, setUserValues] = useState(initialValues);

    const valueHandler = (event) => {
      const { name, value, type, checked } = event.target;
      setUserValues((prevValues) => ({
        ...prevValues,
        [name]: type === 'checkbox' ? checked : value
      }));
    };
  
    const eventLogin = (event) => {
      event.preventDefault();
  
      fetch("http://localhost:9000/api/utenti")
        .then((response) => {
          if (!response.ok) {
            throw new Error('Errore nella richiesta alle API');
          }
          return response.json();
        })
        .then((data) => {
          setUserValues([data]);
          console.log(data);
          const matchedUser = data.find(user => user.email === userValues.email && user.password === userValues.password);
          if (matchedUser) {
            if (userValues.rememberMe) {
              localStorage.setItem("loggedInUser", JSON.stringify(matchedUser)); 
              sessionStorage.removeItem("loggedInUser");
            } else {
              sessionStorage.setItem("loggedInUser", JSON.stringify(matchedUser));
              localStorage.removeItem("loggedInUser");
            }
            console.log("Utente loggato: " + matchedUser.email + " " + matchedUser.password);
            window.location.href = '/user';
          } else {
            alert("Login non riuscito");
          }
        })
        .catch((error) => {
          console.error('Si è verificato un errore:', error);
        })
        .finally(() => {
          setUserValues(initialValues);
        });
    };
  
    return (
      <div className='login template d-flex justify-content-center align-items-center vh-100 bg-primary'>
        <div className='form_container border p-5 rounded bg-white'>
          <form>
            <h3>Sign in</h3>
            <div className='mb-2'>
              <label htmlFor='email'>Email</label>
              <input
                type='email'
                name='email'
                placeholder='Enter Email'
                className='form-control'
                onChange={valueHandler}
                value={userValues.email}
              />
            </div>
            <div className='mb-2'>
              <label htmlFor='password'>Password</label>
              <input
                type='password'
                name='password'
                placeholder='Enter Password'
                className='form-control'
                onChange={valueHandler}
                value={userValues.password}
              />
            </div>
            <div className='mb-2'>
              <input
                type='checkbox'
                name='rememberMe'
                className='custom-control custom-checkbox'
                id='check'
                checked={userValues.rememberMe}
                onChange={valueHandler}
              />
              <label htmlFor='check' className='custom-input-label ms-2'>
                Remember me
              </label>
            </div>
            <div className='d-grid'>
              <button className='btn btn-primary' onClick={eventLogin}>
                Sign in
              </button>
            </div>
            <p className='text-end mt-2'>
              Forgot <a href=''>Password?</a>
              <Link to='/signup' className='ms-2'>
                Sign up
              </Link>
            </p>
          </form>
        </div>
      </div>
    );
  };
  
  export default Login;