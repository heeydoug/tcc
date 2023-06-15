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


      const folderName = 'Tema 1 - Teste'; // Nome da pasta que deseja criar
      const parentFolderId = '1EJrk68WbOvnuCEYN6qkQ1WlmWk2CksVr'; // ID da pasta pai onde deseja criar a nova pasta

      const folderMetadata = {
        name: folderName,
        mimeType: 'application/vnd.google-apps.folder',
        parents: [parentFolderId]
      };

      gapi.client.load('drive', 'v3', function() {
        gapi.client.drive.files.create({
          resource: folderMetadata,
          fields: 'id'
        }).then(function(response) {
          const folderId = response.result.id;
          console.log('Pasta criada com sucesso. ID da pasta:', folderId);
          return folderId;

        }).then(function(folderId){

          const fileId = val.documentId; // ID do documento criado
          const folderIdN = folderId; // ID da pasta em que deseja associar o documento

          const updateRequest = gapi.client.drive.files.update({
            fileId: fileId,
            addParents: folderIdN,
            fields: 'id, parents',
          });

          updateRequest.execute(function (response) {
            console.log('Documento atualizado:', response);
          });

        });
      });
      window.open("https://docs.google.com/document/d/" + val.documentId + "/edit", "_blank");
    });
  }

  function addPermissions() {
    const folderId = '1z4gBiCQ63MALdEYW3xvMI3AX9VZgLpOL'; // ID da pasta que você deseja compartilhar
    const email = 'matheusmilbratz141299@gmail.com'; // E-mail do usuário com quem você deseja compartilhar a pasta
    const role = 'reader'; // Função do usuário (writer, reader, owner, etc.)

    const permission = {
      type: 'user',
      role: role,
      emailAddress: email,
    };

    gapi.client.drive.permissions.create({
      fileId: folderId,
      resource: permission,
    }).then(function(response) {
      console.log('Permissão adicionada com sucesso:', response);
    });
  }

  function listPermissions() {
    const folderId = '1z4gBiCQ63MALdEYW3xvMI3AX9VZgLpOL'; // Substitua pelo ID da pasta

    gapi.client.load('drive', 'v3', function() {
      gapi.client.drive.permissions.list({
        fileId: folderId
      }).then(function(response) {
        const permissions = response.result.permissions;
        for (let i = 0; i < permissions.length; i++) {
          const permission = permissions[i];
          console.log('ID da permissão:', permission.id);
          console.log('Tipo da permissão:', permission.type);

          if (permission.emailAddress) {
            console.log('E-mail do usuário:', permission.emailAddress);
          } else if (permission.domain) {
            console.log('Domínio:', permission.domain);
          } else if (permission.type === 'anyone') {
            console.log('Permissão para qualquer pessoa');
          } else if (permission.type === 'anyoneWithLink') {
            console.log('Permissão para qualquer pessoa com o link');
          } else {
            console.log('Tipo de permissão desconhecido');
          }

          console.log('--------------------------------');
        }
      }).catch(function(error) {
        console.error('Erro ao obter permissões da pasta:', error);
      });
    });


  }

  function removePermissions() {
    const fileId = '1z4gBiCQ63MALdEYW3xvMI3AX9VZgLpOL'; // Substitua pelo ID do arquivo ou pasta
    const permissionId = '01457466587721404510'; // Substitua pelo ID da permissão a ser removida

    gapi.client.load('drive', 'v3', function() {
      gapi.client.drive.permissions.delete({
        fileId: fileId,
        permissionId: permissionId
      }).then(function(response) {
        console.log('Permissão removida com sucesso:', response);
      }).catch(function(error) {
        console.error('Erro ao remover permissão:', error);
      });
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
          <div>
            <button className="btn btn-primary btn-lg mt-3" onClick={() => addPermissions()}>
              Adicionar Permissões
            </button>
          </div>
          <div>
            <button className="btn btn-primary btn-lg mt-3" onClick={() => listPermissions()}>
              Listar Permissões
            </button>
          </div>
          <div>
            <button className="btn btn-primary btn-lg mt-3" onClick={() => removePermissions()}>
              Remover Permissões
            </button>
          </div>


        </div>
      </div>
  );
}

export default App;
