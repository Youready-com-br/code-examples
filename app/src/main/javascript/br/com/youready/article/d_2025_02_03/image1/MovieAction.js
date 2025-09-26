package br.com.youready.article.d_2025_02_03.image1;

import React, { useState } from 'react';

const MovieAction = () => {
    const [actionType, setActionType] = useState('rent');

    const handleButtonClick = () => {
        // Logic to handle button click
        console.log(`Action: ${actionType}`);
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
