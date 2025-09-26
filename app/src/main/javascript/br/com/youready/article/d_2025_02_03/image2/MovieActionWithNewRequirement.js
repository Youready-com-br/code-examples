package br.com.youready.article.d_2025_02_03.image2;

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Assuming react-router-dom for navigation

const MovieAction = () => {
    const [actionType, setActionType] = useState('rent');
    const navigate = useNavigate();

    const handleButtonClick = () => {
        // Um novo if surge quando o botão é clicado
        if (actionType === 'rent') {
            navigate('/alugar-duracao');
        } else {
            // Realiza a ação de compra
            console.log('Buying movie...');
        }
    };

    return (
        <>
            <label>
                <input
                    type="radio"
                    checked={actionType === 'rent'}
                    onChange={() => setActionType('rent')}
                />
                Rent
            </label>

            <label>
                <input
                    type="radio"
                    checked={actionType === 'buy'}
                    onChange={() => setActionType('buy')}
                />
                Buy
            </label>

            <PrimaryButton
                actionType={actionType}
                onClick={handleButtonClick}
            />
        </>
    );
};

// Assuming PrimaryButton is defined elsewhere
const PrimaryButton = ({ actionType, onClick }) => (
    <button onClick={onClick}>{actionType === 'rent' ? 'Rent Movie' : 'Buy Movie'}</button>
);

export default MovieAction;
