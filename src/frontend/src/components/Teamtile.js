import {React} from 'react';
import { Link } from 'react-router-dom';
import './Teamtile.scss';

export const Teamtile = ({teamName}) => {


    return(
        <div className="Teamtile">

             <h1>                 
               <Link to={`/teams/${teamName}`}>    
               
                   {teamName} 
               
               </Link>                   
             </h1>
        </div>
    )
}