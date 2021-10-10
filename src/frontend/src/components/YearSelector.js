import {React} from 'react';
import { Link } from 'react-router-dom';
import './years-list.scss';

export const YearSelector = ({teamName}) =>{

    let years = [];
    const startYear  = process.env.REACT_APP_DATA_START_YEAR;
    const endYear = process.env.REACT_APP_DATA_END_YEAR;

    for(let i = startYear; i <= endYear ; i++){
        years.push(i);
    }


    return(

        <ol className="years-list">
           {years.map(year =>  
            
            (
            
            <li>
                
                <Link to={`/teams/${teamName}/Matches/${year}`}>{year}</Link>
                
            </li>
            
            )            
            
            )}
        </ol>
    )

    
       
}