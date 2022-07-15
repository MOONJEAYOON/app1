import React, { useState } from 'react';
import axios from 'axios';

const Calculator = () => {
    const [infos, setInfos] = useState(null);
    const [formValue, setFormValue] = useState({
        num1: '',
        operator: '',
        num2: ''
    });
    const handleSubmit = () => {
        // store the states in the form data

        const calFormData = {
            num1 : formValue.num1,
            operator : formValue.operator,
            num2 : formValue.num2
        }


        axios({
            url: '/api/calculator',
            method: 'post',
            data: calFormData
        })
            .then(response => {
              //  console.log(response);
                setInfos(response);
            })
            .catch(function (error) {
                console.log(error);
            });


    }

    const handleChange = (event) => {
        setFormValue({
            ...formValue,
            [event.target.name]: event.target.value
        });
    }

    return (
        <>

                <p>Calculator Form</p>
                <input
                    type="text"
                    name="num1"
                    placeholder="숫자입력"
                    value={formValue.num1}
                    onChange={handleChange}
                />
                <select name="operator"
                        onChange={handleChange}
                        value={formValue.operator}
                >
                    <option value="">선택</option>
                    <option value="+">더하기</option>
                    <option value="-">빼기</option>
                    <option value="*">곱하기</option>
                    <option value="/">나누기</option>
                </select>
                <input
                    type="text"
                    name="num2"
                    placeholder="숫자입력"
                    value={formValue.num2}
                    onChange={handleChange}
                />
                <button
                    type="button" onClick={handleSubmit}
                >
                    계산
                </button>
                <p>계산 결과 : {infos && infos.data.data.num3}</p>


        </>

    )
};

export default Calculator;