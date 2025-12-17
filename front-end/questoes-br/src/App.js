import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import Home from './components/Home';
import ApresentacaoJogo from './components/ApresentacaoJogo';
import Footer from './components/Footer'
import CriacaoJogo from './components/CriacaoJogo';
import Ranking from './components/Ranking';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Home></Home>}></Route>
          <Route path='/apresentacao' element={<ApresentacaoJogo></ApresentacaoJogo>}></Route>
          <Route path='/criacao' element={<CriacaoJogo></CriacaoJogo>}></Route>
          <Route path='/ranking' element={<Ranking></Ranking>}></Route>
        </Routes>
      </BrowserRouter>
      <Footer></Footer>
    </div>
  );
}

export default App;