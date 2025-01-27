import React from 'react'
import {Routes,Route} from "react-router";
import App from '../App';

const AppRoutes = () => {
  return (
    <Routes>
              <Route path="/" element={<App />} />
              <Route path="/chat" element={<h1>this is trial</h1>} />
              <Route path='/about' element={<h1>this is service</h1>}/>
              <Route path='*' element={<h1>404 Page not found</h1>}/>  
          </Routes>
  )
}

export default AppRoutes