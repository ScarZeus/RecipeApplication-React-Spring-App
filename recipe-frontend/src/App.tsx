import './App.css';
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import Home from './components/Home';
function App() {
  return (
     <BrowserRouter>
      <Routes>
          <Route path = "/" element = {<Home />}/>
          {/* <Route path = "/login" element = {<Login />}/>
          <Route path = "/register" element = {<Search />}/>
          <Route path = "/user/:id" element = {<UserDetail />}/> */}
      </Routes>
     </BrowserRouter>
  )
}

export default App
