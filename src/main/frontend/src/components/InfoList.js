import { useState } from "react";
import axios from 'axios';

const InfoList = ({ blogs }) => {
    //const [delUrl, setDelUrl] = useState(null);





    return (
        <div className="blog-list">
            {blogs.map(blog => (
                <ul className="blog-preview" key={blog.calculatorId}>
                    <li data-name={blog.calculatorId}><b>{blog.calculatorId}</b> : {blog.num1} {blog.operator} {blog.num2} = {blog.num3} <button data-name={blog.calculatorId} >삭제</button> </li>
                </ul>
            ))}
        </div>
    );
};

export default InfoList;