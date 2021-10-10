import './App.scss';
import { TeamPage } from './pages/TeamPage';
import { MatchPage } from './pages/MatchPage';
import {HomePage} from './components/HomePage';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

function App() {
  return (
    <div className="App">

      <Router>

        <Switch>
        <Route path="/teams/:teamName/Matches/:year">
            <MatchPage />
        </Route>
        <Route path="/teams/:teamName">
             <TeamPage/>
        </Route>
        <Route path="/">
             <HomePage />
        </Route>


        </Switch>
      </Router>
    </div>
  );
}

export default App;
