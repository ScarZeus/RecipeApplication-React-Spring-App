import './App.css';
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import Login from './view/Pages/LoginPage';
import Home from './view/Pages/HomePage';

function App() {
  return (
      <Routes>
          <Route path = "/" element = {<Login />}/>
          <Route path = "/home" element = {<Home />}/>
          {/* <Route path = "/register" element = {<Search />}/>
          <Route path = "/user/:id" element = {<UserDetail />}/> */}
      </Routes>
  )
}

export default App;
