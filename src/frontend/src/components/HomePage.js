import { useEffect, useState } from "react";
import {React} from 'react';
import { Teamtile } from "./Teamtile";
import './HomePage.scss';


export const HomePage = () =>{

    const [teams, setTeams] = useState([]);
    useEffect(

        () =>  {

            const fetchAllTeam = async () =>{

                const response =  await fetch(`http://localhost:8080/team`);
                const data = await response.json();
                setTeams(data);
            };

            fetchAllTeam();


        }, []

    )


    return(

        <div className="HomePage">

          <div className="header-section">
              <h1 className="app-name"> Code Loader IPL Board</h1>
          </div>

          <div className="team-grid">

            { teams.map(team => <Teamtile teamName={team.teamName}></Teamtile>)}
          </div>
        </div>
    )
}