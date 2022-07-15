import React from 'react';
import { Link } from 'react-router-dom';

function Header(props) {
    return (
        <>
            <ul>
                <Link to="/sign_in"><li>로그인</li></Link>
                <Link to="/sign_up"><li>회원가입</li></Link>
                <Link to="/calculator"><li>계산기</li></Link>
                <Link to="/history"><li>히스토리</li></Link>
            </ul>

        </>
    );
}

export default Header;