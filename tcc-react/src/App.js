import './App.css';
import React, { useEffect } from 'react';
import LoginButton from "./components/login";
import LogoutButton from "./components/logout";
import { gapi } from 'gapi-script';

const clientId = "308424476532-e40blk46kh67iussdbce2655m9lnacoq.apps.googleusercontent.com";
const apiKey = "API_KEY";
const scopes = "https://www.googleapis.com/auth/drive";

function App() {

  useEffect(() => {
    function start() {
      gapi.client.init({
        apiKey: apiKey,
        clientId: clientId,
        scope: scopes
      });
    }
    gapi.load('client:auth2', start);
  }, []);

  function zeroFill(i) {
    return (i < 10 ? '0' : '') + i;
  }

  function getDateString() {
    const date = new Date();
    const year = date.getFullYear();
    const month = zeroFill(date.getMonth() + 1);
    const day = zeroFill(date.getDate());
    return day + '/' + month + '/' + year;
  }

  function getTimeString() {
    const date = new Date();
    return date.toLocaleTimeString();
  }

  function createFile(tag) {
    var accessToken = gapi.auth.getToken().access_token;
    var fileName = tag + " " + getDateString() + " " + getTimeString();
    fetch('https://docs.googleapis.com/v1/documents?title=' + fileName, {
      method: "POST",
      headers: new Headers({ 'Authorization': 'Bearer ' + accessToken })

    }).then((res) => {
      return res.json();

    }).then(function (val) {
      console.log(val);
      console.log(val.documentId);
      window.open("https://docs.google.com/document/d/" + val.documentId + "/edit", "_blank");
    });

  }

  return (
      <div className="container d-flex align-items-center justify-content-center vh-100">
        <div className="text-center">
          <h1 className="mb-4">Integração com Google Docs</h1>
          <div className="mb-3">
            <LoginButton className="btn btn-primary" />
          </div>
          <div className="mb-3">
            <LogoutButton className="btn btn-secondary" />
          </div>
          <button className="btn btn-primary btn-lg mt-3" onClick={() => createFile('Artigo: Tema 1 -')}>
            Criar Documento
          </button>
        </div>
      </div>
  );
}

export default App;
