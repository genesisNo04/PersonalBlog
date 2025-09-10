import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import {useState} from "react"; 

function App() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");


  
  return (
    <>
      <div className='container'>
        <h1>Login</h1>
        <form className="form">
          <label htmlFor="username">Username: </label>
          <input type="text" id="username"/>

          <label htmlFor="password">Password: </label>
          <input type="password" id="password"/>

          <button>Login</button>
        </form>
      </div>
    </>
  )
}

export default App
