import { Link } from "react-router-dom";

function Header() {
    return (
        <div>
            <nav>
                <ul>
                    <li>
                        <Link to='/'> Início</Link>
                    </li>
                    <li>
                        <Link to='/apresentacao'> apresentação do jogo</Link>
                    </li>
                </ul>
            </nav>
        </div>
    )
}

export default Header;