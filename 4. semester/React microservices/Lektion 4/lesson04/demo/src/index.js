import React from 'react';
import ReactDOM from 'react-dom';
import ParentFunction from './components/lifecycle/lifeoffunction/ParentFunction';
import UseOnlineHook from './components/onlinehook/UseOnlineHook';


ReactDOM.render(
    <React.StrictMode>
        <ParentFunction initialData={"hest"}/>

    </React.StrictMode>,
    document.getElementById('root')
);


