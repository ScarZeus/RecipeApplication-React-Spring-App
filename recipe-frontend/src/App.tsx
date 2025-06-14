import './App.css';
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import Home from './components/Home';
import Login from './components/Login';

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
