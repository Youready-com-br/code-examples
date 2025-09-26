package br.com.youready.article.d_2025_02_03.image3;

import React, { useState } from 'react';

const MovieAction = () => {
    const [actionType, setActionType] = useState('rent');

    return (
        <>
            <RentFlow
                isSelected={actionType === 'rent'}
                onSelect={() => setActionType('rent')}
            />

            <BuyFlow
                isSelected={actionType === 'buy'}
                onSelect={() => setActionType('buy')}
            />
        </>
    );
};

// Assuming RentFlow and BuyFlow components are defined elsewhere
const RentFlow = ({ isSelected, onSelect }) => (
    <label>
        <input type="radio" checked={isSelected} onChange={onSelect} />
        Rent
    </label>
);

const BuyFlow = ({ isSelected, onSelect }) => (
    <label>
        <input type="radio" checked={isSelected} onChange={onSelect} />
        Buy
    </label>
);

export default MovieAction;
