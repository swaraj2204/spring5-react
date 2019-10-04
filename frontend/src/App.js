import React from 'react';
import logo from './logo.svg';
import './App.css';
import FrontendApp from "./component/FrontendApp";


class App extends React.Component {
    render() {
        return (
            <div className="App">
                <FrontendApp></FrontendApp>
            </div>
        );
    }
}

export default App;
