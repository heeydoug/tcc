import './App.css';
import React, { useEffect } from 'react';
import LoginButton from "./components/login";
import LogoutButton from "./components/logout";
import { gapi } from 'gapi-script';

const clientId = "308424476532-e40blk46kh67iussdbce2655m9lnacoq.apps.googleusercontent.com";
const apiKey = "AIzaSyB3YL3rMqDqt_BY248XBIojJ__yb6Szlss";
const scopes = "https://www.googleapis.com/auth/drive";

function App() {

  useEffect( () => {
    function start(){
      gapi.client.init({
        apiKey: apiKey,
        clientId: clientId,
        scope: scopes
      });
    };
    gapi.load('client:auth2', start);
  });

  function zeroFill(i){
    return (i < 10 ? '0' : '') + i;
  }
  function getDateString(){
    const date = new Date();
    const year = date.getFullYear();
    const month = zeroFill(date.getMonth()+1);
    const day = zeroFill(date.getDate());
    return day + '/' + month + '/' + year;
  }
  function getTimeString(){
    const date = new Date();
    return date.toLocaleTimeString();
  }

  function createFile(tag){
    var accessToken = gapi.auth.getToken().access_token;
    var fileName = tag + " " + getDateString() + " " + getTimeString();
    fetch('https://docs.googleapis.com/v1/documents?title=' + fileName, {
      method: "POST",
      headers: new Headers( { 'Authorization': 'Bearer ' + accessToken })

    }).then((res) => {
      return res.json();

    }).then(function (val){
      console.log(val);
      console.log(val.documentId);
      window.open("https://docs.google.com/document/d/" + val.documentId + "/edit", "_blank");
    });

  }

  return (
      <div className="App">
        <LoginButton />
        <LogoutButton />
        <button onClick={() => createFile('Artigo: Tema 1 -')}>Criar Documento</button>
      </div>
  );
}

export default App;
